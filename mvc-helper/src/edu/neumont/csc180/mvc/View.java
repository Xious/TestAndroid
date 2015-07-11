package edu.neumont.csc180.mvc;

public interface View<M> extends Model.Listener<M> {
	void setListener(View.Listener listener);
	
	interface Listener {
	}
}
