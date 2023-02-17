package com.viettelpost.scrape.ultils;

import com.viettelpost.scrape.models.tiktok.response.listcomment.ListCommentComments;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {

    private List<ListCommentComments> listComment;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List<ListCommentComments> listComment) {
        this.listComment = listComment;
        workbook = new XSSFWorkbook();
    }

    private void writeHeader() {
        sheet = workbook.createSheet("Comment");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "STT", style);
        createCell(row, 1, "NickName", style);
        createCell(row, 2, "Comment", style);
        createCell(row, 3, "Likes", style);
        createCell(row, 4, "CreateTime", style);
        createCell(row, 5, "ReplyCommentTotal", style);
        createCell(row, 6, "Link", style);
    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        int count = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        if(!TextUtils.isNullOrEmpty(listComment))
        for (ListCommentComments record : listComment) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, count, style);
            createCell(row, columnCount++, TextUtils.checkNull(record.getUser().getNickname()), style);
            createCell(row, columnCount++, TextUtils.checkNull(record.getText()), style);
            createCell(row, columnCount++, record.getDigg_count(), style);
            createCell(row, columnCount++, record.getCreate_time()!=null ? DateUtils.convertLongtoDate(record.getCreate_time()) : "", style);
            createCell(row, columnCount++, TextUtils.checkNull(record.getReply_comment_total(), "0"), style);
            createCell(row, columnCount++, TextUtils.checkNull(record.getShare_info().getUrl()), style);
            count++;
        }
    }
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }


}
