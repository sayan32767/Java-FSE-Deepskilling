CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_BonusPercent/100)
    WHERE Department = p_Department;
    
    COMMIT;
END UpdateEmployeeBonus;
/