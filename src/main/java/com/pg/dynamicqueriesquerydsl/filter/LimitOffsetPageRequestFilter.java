package com.pg.dynamicqueriesquerydsl.filter;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class LimitOffsetPageRequestFilter implements Pageable {
	 private int limit;

	    private int offset;
	    
	    // Constructor could be expanded if sorting is needed
	    private Sort sort = Sort.by(Sort.Direction.ASC, "id");

	    public LimitOffsetPageRequestFilter(int limit, int offset) {
	        if (limit < 1) {
	            throw new IllegalArgumentException("Limit must not be less than one!");
	        }
	        if (offset < 0) {
	            throw new IllegalArgumentException("Offset index must not be less than zero!");
	        }
	        this.limit = limit;
	        this.offset = offset;
	    }

	    @Override
	    public int getPageNumber() {
	        return offset / limit;
	    }

	    @Override
	    public int getPageSize() {
	        return limit;
	    }

	    @Override
	    public long getOffset() {
	        return offset;
	    }

	    @Override
	    public Sort getSort() {
	        return sort;
	    }

	    @Override
	    public Pageable next() {
	        // Typecast possible because number of entries cannot be bigger than integer (primary key is integer)
	        return new LimitOffsetPageRequestFilter(getPageSize(), (int) (getOffset() + getPageSize()));
	    }

	    public Pageable previous() {
	        // The integers are positive. Subtracting does not let them become bigger than integer.
	        return hasPrevious() ?
	                new LimitOffsetPageRequestFilter(getPageSize(), (int) (getOffset() - getPageSize())): this;
	    }

	    @Override
	    public Pageable previousOrFirst() {
	        return hasPrevious() ? previous() : first();
	    }

	    @Override
	    public Pageable first() {
	        return new LimitOffsetPageRequestFilter(getPageSize(), 0);
	    }

	    @Override
	    public boolean hasPrevious() {
	        return offset > limit;
	    }

}
