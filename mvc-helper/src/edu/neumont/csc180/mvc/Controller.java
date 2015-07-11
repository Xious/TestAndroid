package edu.neumont.csc180.mvc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/** 
 * A class that abstracts away some of the more common boilerplate operations that an
 * activity does.
 * 
 * Created for the expressed purpose of alleviating extension classes from importing Android libraries.
 * 
 * @author jzheaux
 *
 */
public class Controller<M extends Model<M>> extends Activity implements View.Listener {
	protected M model;
	protected String viewName;
	
	public Controller() {}
	
	public Controller(M model, String viewName) {
		 this.model = model;
		 this.viewName = viewName;
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Intent i = this.getIntent();
        @SuppressWarnings("unchecked")
		M model = (M)i.getSerializableExtra("model");
        String viewName = (String)i.getStringExtra("viewName");
        
        if ( model != null ) {
        	this.model = model;
        	this.viewName = viewName;
        }
        
        setContentView();
    }
    
    protected void setContentView() {
    	int viewResourceId = getResources().getIdentifier(viewName, "layout", getPackageName());
        @SuppressWarnings("unchecked")
		View<M> view = (View<M>)android.view.View.inflate(this, viewResourceId, null);
        model.setListener(view);
        view.setListener(this);
        
        setContentView((android.view.View)view);
    }
    
    protected <N extends Model<N>> void goTo(Model<N> model, String viewName, Class<?> clazz) {
    	Intent intent = new Intent(this, clazz);
    	intent.putExtra("model", model);
    	intent.putExtra("viewName", viewName);
    	this.startActivity(intent);	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	int menuResourceId = getResources().getIdentifier(viewName, "menu", getPackageName());
    	
        getMenuInflater().inflate(menuResourceId, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        int actionSettingsId = getResources().getIdentifier("action_settings", "id", getPackageName());
        if (id == actionSettingsId) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
}
