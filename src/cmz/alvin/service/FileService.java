package cmz.alvin.service;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.Buffer;

import android.content.Context;
public class FileService {
	
	/**
	 * 保存文件
	 * @param filename 文件名称
	 * @param content 文件内容
	 */
	private Context context;
	public FileService(Context context){
		this.context=context;
	}
	public void save(String filename, String content) throws Exception {
		FileOutputStream outStream=context.openFileOutput(filename,
				context.MODE_PRIVATE);
		outStream.write(content.getBytes());
		outStream.close();
	}
	public String read(String filename) throws Exception{
		FileInputStream inStream=context.openFileInput(filename);
		ByteArrayOutputStream outStream=new ByteArrayOutputStream();
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=inStream.read(buffer))!=-1);{
			outStream.write(buffer,0,len);
		}
		byte[]data=outStream.toByteArray();
		return new String(data);
	}
}
