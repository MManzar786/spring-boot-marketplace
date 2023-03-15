package app.dto;

import java.util.List;

import org.springframework.data.domain.Pageable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaginatedResponse<T> {
	    private List<T> data;
	    private long totalElements;
	    private int totalPages;
	    private int pageNumber;
	    private int pageSize;

	    public static <T> PaginatedResponse<T> of(List<T> content, long totalElements, Pageable pageable) {
	    	PaginatedResponse<T> response = new PaginatedResponse<>();
	        response.data = content;
	        response.totalElements = totalElements;
	        response.totalPages = (int) Math.ceil((double) totalElements / pageable.getPageSize());
	        response.pageNumber = pageable.getPageNumber();
	        response.pageSize = pageable.getPageSize();
	        return response;
	    }

	}
