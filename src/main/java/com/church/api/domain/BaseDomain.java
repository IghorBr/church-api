package com.church.api.domain;

import java.util.Objects;

public abstract class BaseDomain {
	
	protected abstract Long getId();
	
	@Override
	public String toString() {
		return "" + getId() + "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDomain other = (BaseDomain) obj;
		return Objects.equals(getId(), other.getId());
	}

}
