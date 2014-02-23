package cmz.alvin.file;

import cmz.alvin.service.FileService;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText filenameText=null;
	EditText contentText=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new ButtonClickListener());
    }
    private final class ButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			filenameText=(EditText)findViewById(R.id.filename);
			contentText=(EditText)findViewById(R.id.filecontent);
			String filename=filenameText.getText().toString();
			String content=contentText.getText().toString();
			//保存文件的类
		    FileService service=new FileService(getApplicationContext());
		    try {
				service.save(filename,content);
				Toast.makeText(getApplicationContext(), R.string.success,1).show();
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), R.string.failed,1).show();
			}
		    
		}
    	
    }
}