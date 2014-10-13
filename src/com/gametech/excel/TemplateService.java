package com.gametech.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.gametech.excel.model.Classify;
import com.gametech.excel.model.ExcelBase;
import com.gametech.utils.HttpUtils;
import com.gametech.utils.ReflectUtils;
import com.gametech.utils.StringUtils;


public class TemplateService{
	public final static  Map<String, Map<Integer, ExcelBase>> resouceMap = new HashMap<String, Map<Integer,ExcelBase>>();
	public void init(){
		
		this.readFile(this.getExcelPath());
		//System.out.println(this.getAll(Classify.class).values().size() + "aa" + this.getValue(2, Classify.class).getName());
	}
	@SuppressWarnings("unchecked")
	public <T extends ExcelBase> Map<Integer, T> getAll(Class<T> t){
		return (Map<Integer, T>)TemplateService.resouceMap.get(t.getName());
	}
	public <T extends ExcelBase> T getValue(int id,Class<T> t){
		Map<Integer, T> map = this.getAll(t);
		if(map != null){
			return map.get(id);
		}
		return null;
	}
	private  void readFile(String path){
		File filedir = new File(path);
		if(filedir.exists()){
			//获取文件夹下的所有文件
			File[] allFiles = filedir.listFiles();
			if(allFiles != null && allFiles.length > 0){
				BufferedReader read = null;
				try{
					InputStream input = null;
					for(File file : allFiles){
						if(file == null){
							continue;
						}
						input = new FileInputStream(file);
						Workbook book = WorkbookFactory.create(input);
						Sheet sheet = book.getSheetAt(0);
						this.saveValue(sheet, file.getName());
						
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
	private String getExcelPath(){
		//String path = System.getProperty("user.dir")+ "/WebRoot/WEB-INF/config/excel";
		String path = HttpUtils.getPath() + "/WEB-INF/config/excel";
		return path;
	}
	/**
	 * 获取类的全名
	 * @author guangshuai.wang
	 * @param name	文件名
	 * @return
	 * String
	 * @date:2014-9-8
	 */
	private String getClassName(String name){
		return "com.gametech.excel.model." + StringUtils.getClassNameByFilename(name);
	}
	/**
	 * 把excel表中的值存入到内存中。
	 * @author guangshuai.wang
	 * @param sheet
	 * void
	 * @date:2014-9-7
	 */
	private void saveValue(Sheet sheet,String filename){
		//创建类
		int j = 0,k = 0;
		try {
			
			Row row = sheet.getRow(1);
			int columnNum = row.getLastCellNum() - row.getFirstCellNum();
			int rowNum = sheet.getLastRowNum() + 1;
			Map<Integer, ExcelBase> map  = new HashMap<Integer, ExcelBase>();
			for(int n = 2;n < rowNum ;n ++ ){
				Row every = sheet.getRow(n);
				k = n;
				Class<?> entity = Class.forName(getClassName(filename));
				ExcelBase excel = (ExcelBase)entity.newInstance();
				for(int i = 0;i < columnNum;i++){
					j = i;
					if(every.getCell(i).getCellType() == HSSFCell.CELL_TYPE_STRING){
						String value = every.getCell(i).getStringCellValue();
						ReflectUtils.setter(excel, row.getCell(i).getStringCellValue(),value , String.class);
					} else {
						int value = (int) every.getCell(i).getNumericCellValue();
						ReflectUtils.setter(excel, row.getCell(i).getStringCellValue(),String.valueOf(value) , int.class);
					}
					
				}
				map.put(excel.getTemplateId(), excel);
			}
			resouceMap.put(this.getClassName(filename), map);
			System.out.println("加载数据" + this.getExcelPath() + "/" + filename + "成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println(filename + "数据格式错误，位置：第" + k +"行，第" + j + "行");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			//e.printStackTrace();
			System.out.println(filename + "数据格式错误，位置：第" + k +"行，第" + j + "行");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
