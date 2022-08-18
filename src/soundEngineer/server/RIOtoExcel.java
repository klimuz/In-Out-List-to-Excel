package soundEngineer.server;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import soundEngineer.step2.ChannelStrip;
import soundEngineer.step2.NormaliseListsGui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RIOtoExcel {
    HSSFWorkbook book = new HSSFWorkbook();
    HSSFSheet sheet = book.createSheet("Input list");
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setBold(true);
        HSSFCellStyle style = book.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THICK);
        style.setBorderBottom(BorderStyle.THICK);
        style.setBorderLeft(BorderStyle.THICK);
        style.setBorderRight(BorderStyle.THICK);
        return style;
    }

    private static HSSFCellStyle createStyleForData(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setBold(false);
        HSSFCellStyle style = book.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private static HSSFCellStyle createStyleForLeftData(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setBold(false);
        HSSFCellStyle style = book.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THICK);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private static HSSFCellStyle createStyleForLeftBottomData(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setBold(false);
        HSSFCellStyle style = book.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THICK);
        style.setBorderLeft(BorderStyle.THICK);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private static HSSFCellStyle createStyleForRightBottomData(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setBold(false);
        HSSFCellStyle style = book.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THICK);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THICK);
        return style;
    }

    private static HSSFCellStyle createStyleForBottomData(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setBold(false);
        HSSFCellStyle style = book.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THICK);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private static HSSFCellStyle createStyleForRightData(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setBold(false);
        HSSFCellStyle style = book.createCellStyle();
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THICK);
        return style;
    }

    //create input list start
    private void createHeader(int rowNum) {
        //HSSFWorkbook book = this.book;

        Row row;
        Cell cell;
        //HSSFSheet sheet = this.sheet;

        row = sheet.createRow(rowNum);
        row.setHeight((short) 550);
        //ch
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("CH");
        cell.setCellStyle(createStyleForTitle(book));
        //rio
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("RIO");
        cell.setCellStyle(createStyleForTitle(book));
        //instrument
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("INSTRUMENT");
        cell.setCellStyle(createStyleForTitle(book));
        sheet.setColumnWidth(2, 5000);
        //pickup
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("PICKUP");
        cell.setCellStyle(createStyleForTitle(book));
        //note
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("NOTE");
        cell.setCellStyle(createStyleForTitle(book));
        sheet.setColumnWidth(4, 3000);
        //return row;
    }

     public void inputListRIOtoExel(ArrayList<ChannelStrip> inputList) throws IOException {

         Sheet sheet = this.sheet;
         sheet.setHorizontallyCenter(true);

         int rowNum = 0;
         int channelNum = 0;
         int rioNum = 1;
         int rioChan = 1;
         Cell cell;
         Row row;
         createHeader(rowNum);
         //data
         for (; channelNum + 1 < inputList.size();){
             rowNum++;
             channelNum++;
             row = sheet.createRow(rowNum);
             boolean isBottom = channelNum ==  inputList.size()-1;

             //ch
             cell = row.createCell(0, CellType.STRING);
             if (isBottom){
                 cell.setCellStyle(createStyleForLeftBottomData(book));
             }else cell.setCellStyle(createStyleForLeftData(book));
             cell.setCellValue(channelNum);

             //rio
             cell = row.createCell(1, CellType.STRING);
             if (isBottom){
                 cell.setCellStyle(createStyleForBottomData(book));
             }else cell.setCellStyle(createStyleForData(book));
             cell.setCellValue(rioNum + "-" + rioChan);
             if (channelNum == 32 || channelNum == 64 || channelNum == 96){
                 rowNum++;
                 createHeader(rowNum);
                 rioNum++;
                 rioChan = 0;
             }
             rioChan++;
//instrument
             cell = row.createCell(2,CellType.STRING);
             if (isBottom){
                 cell.setCellStyle(createStyleForBottomData(book));
             }else cell.setCellStyle(createStyleForData(book));
             cell.setCellValue(NormaliseListsGui.stripList.get(channelNum).getStripName());

             //pickup
             cell = row.createCell(3, CellType.STRING);
             if (isBottom){
                 cell.setCellStyle(createStyleForBottomData(book));
             }else cell.setCellStyle(createStyleForData(book));
             cell.setCellValue(NormaliseListsGui.stripList.get(channelNum).getStripPickup());

             //note
             cell = row.createCell(4, CellType.STRING);
             if (isBottom){
                 cell.setCellStyle(createStyleForRightBottomData(book));
             }else cell.setCellStyle(createStyleForRightData(book));
             cell.setCellValue(NormaliseListsGui.stripList.get(channelNum).getStripNote());
         }
    File file1 = new File(ProjectData.filePath + "/" + ProjectData.projectName + " RIO-In-out list.xls");
        file1.getParentFile().mkdirs();

    FileOutputStream outFile = new FileOutputStream(file1);
        book.write(outFile);
        outFile.close();
}

}

