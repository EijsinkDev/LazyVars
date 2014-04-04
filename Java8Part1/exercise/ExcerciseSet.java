package exercise;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class ExcerciseSet<T> implements Set<T> {

	private Set<T> delegate;
	private Set<Listener<T>> addListeners;
	private Predicate<T> validator;

	public ExcerciseSet() {
		delegate = new HashSet<>();
		addListeners = new HashSet<>();
		validator = null;
	}

	public boolean add(T arg0) {
		if (validator == null || validator.test((arg0))) {
			boolean result = delegate.add(arg0);
			if (result) {
				for (Listener<T> listener : addListeners) {
					listener.objectAdded(arg0);
				}
			}
			return result;
		} else {
			return false;
		}
	}

	public boolean addAll(Collection<? extends T> arg0) {
		boolean result = false;
		for (T object : arg0) {
			if (add(object)) {
				result = true;
			}
		}
		return result;
	}

	public void clear() {
		for (T object : this) {
			remove(object);
		}
	}

	public boolean contains(Object arg0) {
		return delegate.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0) {
		return delegate.containsAll(arg0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((delegate == null) ? 0 : delegate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExcerciseSet other = (ExcerciseSet) obj;
		if (delegate == null) {
			if (other.delegate != null)
				return false;
		} else if (!delegate.equals(other.delegate))
			return false;
		return true;
	}

	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	public Iterator<T> iterator() {
		return delegate.iterator();
	}

	public boolean remove(Object arg0) {
		return delegate.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0) {
		return delegate.removeAll(arg0);
	}

	public boolean retainAll(Collection<?> arg0) {
		boolean result = false;
		for (T object : this) {
			if (!arg0.contains(object)) {
				remove(object);
				result = true;
			}
		}
		return result;
	}

	public int size() {
		return delegate.size();
	}

	public Object[] toArray() {
		return delegate.toArray();
	}

	public <T> T[] toArray(T[] arg0) {
		return delegate.toArray(arg0);
	}

	public void addListener(Listener<T> listener) {
		addListeners.add(listener);
	}

	public void setValidator(Predicate<T> validator) {
		this.validator = validator;
	}
}
