--The following code defines a variable and assigns it a value
DECLARE
my_var VARCHAR2(30);
BEGIN
my_var := '&input';
dbms_output.put_line('Hello '|| my_var );
END;
/