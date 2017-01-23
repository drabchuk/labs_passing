create or replace PROCEDURE PASS_LAB
(
  STUDENT IN VARCHAR2
, LAB_ID IN NUMBER  
, SCORE IN NUMBER  
) AS 
BEGIN
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
  INSERT INTO passed_lab VALUES (STUDENT, LAB_ID, SCORE, SYSDATE);
  COMMIT;
END PASS_LAB;