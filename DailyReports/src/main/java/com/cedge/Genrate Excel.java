// <dependency>
//     <groupId>org.apache.poi</groupId>
//     <artifactId>poi-ooxml</artifactId>
//     <version>5.2.3</version>
// </dependency>

import com.akit.entity.DailyReports;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelGeneratorUtil {

    public static String generateExcel(List<DailyReports> reportsList) {
        String folderPath = "/Prathmesh/ExcelReports";
        LocalDate today = LocalDate.now();
        String fileName = "DailyReport-" + today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".xlsx";
        String filePath = folderPath + "/" + fileName;

        try {
            // Create folder if it doesn't exist
            Files.createDirectories(Paths.get(folderPath));

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Daily Report");

            // Header Row
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Bank");
            header.createCell(1).setCellValue("Successful");
            header.createCell(2).setCellValue("Unsuccessful");
            header.createCell(3).setCellValue("Success %");
            header.createCell(4).setCellValue("Unsuccess %");
            header.createCell(5).setCellValue("Date");

            // Data Rows
            int rowNum = 1;
            for (DailyReports report : reportsList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(report.getBank());
                row.createCell(1).setCellValue(report.getSuccessful());
                row.createCell(2).setCellValue(report.getUnsuccessful());
                row.createCell(3).setCellValue(report.getSuccessPercentage());
                row.createCell(4).setCellValue(report.getUnsuccessPercentage());
                row.createCell(5).setCellValue(report.getDate().toString());
            }

            // Auto-size columns
            for (int i = 0; i <= 5; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write to file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            workbook.close();

            System.out.println("✅ Excel file created at: " + filePath);
            return filePath;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Error generating Excel file: " + e.getMessage());
        }
    }
}


//******************************************************************************* */

// service method of Dailyreport
@Autowired
private DailyReportsRepo drRepo;

public void generateAndSaveExcel(LocalDate date) {
    List<DailyReports> reports = drRepo.findByDate(date);
    ExcelGeneratorUtil.generateExcel(reports);
}




//******************************************************************************* */

// Dailyrepo repository

List<DailyReports> findByDate(LocalDate date);
