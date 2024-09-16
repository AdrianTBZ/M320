package V1_SeriesB;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MyList<T> extends AbstractList<T> {
	private List<T> list;

	public MyList() {
		list = new ArrayList<>();
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean add(T element) {
		return list.add(element);
	}

	@Override
	public T remove(int index) {
		return list.remove(index);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int indexOf(Object o) {
		return list.indexOf(o);
	}
}
