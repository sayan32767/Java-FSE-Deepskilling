DECLARE
    CURSOR c_loans IS
        SELECT LoanID, CustomerID FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR loan IN c_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan.LoanID || ' for Customer ' || loan.CustomerID || ' is due soon.');
    END LOOP;
END;
/
