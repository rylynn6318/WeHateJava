package logic;

import java.sql.SQLException;

import DB.DocumentParser;
import enums.Bool;

public class DocumentManager {
	public static void uploadDocument(String studentId, int documentType, String filePath)    //파일 업로드는 어케 해야하지??
    {

    }

    public static void updateDocument(String studentId, int documentType, java.util.Date submissionDate, java.util.Date diagnosisDate, Bool isValid)
    {
        @SuppressWarnings("deprecation")
        java.sql.Date submissionSqlDate = new java.sql.Date(submissionDate.getYear(), submissionDate.getMonth(), submissionDate.getDay());
        @SuppressWarnings("deprecation")
        java.sql.Date diagnosisSqlDate = new java.sql.Date(diagnosisDate.getYear(), diagnosisDate.getMonth(), diagnosisDate.getDay());

        // DocumentParser.updateDocument(sIsValid, submissionSqlDate, diagnosisSqlDate);
    }
}
