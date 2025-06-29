DECLARE
    CURSOR c_customers IS
        SELECT CustomerID FROM Customers
        WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) > 60;
BEGIN
    FOR cust IN c_customers LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;
    END LOOP;
END;
/
