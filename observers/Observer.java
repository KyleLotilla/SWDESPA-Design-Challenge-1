package observers;

import model.Subject;

public interface Observer {
	public void update(Subject subChanged);
}
