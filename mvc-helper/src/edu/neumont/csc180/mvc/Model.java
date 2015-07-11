package edu.neumont.csc180.mvc;

import java.io.Serializable;

public interface Model<M> extends Serializable {
	void setListener(Model.Listener<M> listener);
	
	interface Listener<M> {
		void update(M data);
		void updateDesc(M data);
		void updateImg(M data);
	}
}
