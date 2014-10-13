package com.gametech.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.gametech.utils.StringUtils;


public class ExcelUtils {
	
	/**服务器启动时，初始化数据**/
	public void init(){
		this.readFile(this.getExcelPath());
	}
	public String getExcelPath(){
		String path = System.getProperty("user.dir")+ "/WebRoot/WEB-INF/config/excel";
		//String path = HttpUtils.getPath() + "/WEB-INF/config/excel";
		return path;
	}
	/**
	 * 获取文件在存储路径
	 * @author guangshuai.wang
	 * @param name
	 * @return
	 * String
	 * @date:2014-9-8
	 */
	private String getClassPath(String name){
		return System.getProperty("user.dir") + "/src/com/gametech/excel/model/" + name;
	}
	
	/**读取文件**/
	public void readFile(String path){
		
		File filedir = new File(path);
		if(filedir.exists()){
			//获取文件夹下的所有文件
			File[] allFiles = filedir.listFiles();
			if(allFiles != null && allFiles.length > 0){
				BufferedReader read = null;
				try{
					for(File file : allFiles){
						if(file == null){
							continue;
						}
						this.buildClass(file);
						
					}
				}catch (Exception e) {
					e.printStackTrace();// TODO: handle exception
				}finally{
					if(read != null){
						try {
							read.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		}
	}
	/**
	 * 根据excel表创建对应的类
	 * @author guangshuai.wang
	 * @param file
	 * void
	 * @date:2014-9-7
	 */
	private void buildClass(File file){
		InputStream input = null;
		///生成的文件类
		FileOutputStream out = null;
		StringBuilder class_str = new StringBuilder();
		//设置包名：
		class_str.append("package com.gametech.excel.model;\n\n");
		//设置类名
		String className = StringUtils.getClassNameByFilename(file.getName());
		class_str.append("public class " +className + " extends ExcelBase {\n\t");
		//记录所有的字段
		StringBuilder classField = new StringBuilder();
		//记录所有的get/set方法
		StringBuilder classMethod = new StringBuilder();
		try {
			input = new FileInputStream(file);
			Workbook book = WorkbookFactory.create(input);
			Sheet sheet = book.getSheetAt(0);
			//在excel中，第一行是注释，第二行是字段名,第三行起为数据
			Row row1 = sheet.getRow(0);
			Row row2 = sheet.getRow(1);
			Row row3 = sheet.getRow(2);
			int maxField = row1.getLastCellNum() - row1.getFirstCellNum();
			String type = "";
			for(int i = 0; i < maxField ; i++){
				classField.append("//" + row1.getCell(i).getStringCellValue() + "\n\t");
				
				if(row3.getCell(i).getCellType() == HSSFCell.CELL_TYPE_STRING){
					type = "String";
				} else {
					type = "int";
				}
				classField.append("public "+ type + " "+ row2.getCell(i).getStringCellValue() + ";\n\t");
				classMethod.append("public void set" + StringUtils.firstToUpper(row2.getCell(i).getStringCellValue()) + "("+ type +" "+ row2.getCell(i).getStringCellValue() +"){\n\t\t");
				classMethod.append("this." + row2.getCell(i).getStringCellValue() + " = "+row2.getCell(i).getStringCellValue() +";\n\t}\n\t");
				classMethod.append("public " + type + " get" + StringUtils.firstToUpper(row2.getCell(i).getStringCellValue() + "(){\n\t\t"));
				classMethod.append("return " + row2.getCell(i).getStringCellValue() +";\n\t}\n\t");
				
			}
			class_str.append(classField.toString());
			class_str.append("\n\t");
			class_str.append(classMethod.toString());
			//类结束
			class_str.append("\n}");                                                               
			out = new FileOutputStream(this.getClassPath(StringUtils.getClassNameByFilename(file.getName()))+ ".java");
			out.write(class_str.toString().getBytes("utf8"));
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		ExcelUtils excel = new ExcelUtils();
		excel.init();
	}
}
