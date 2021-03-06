package travelcompany.common.business.search;

public abstract class BaseSearchCondition <ID>{
    protected ID id;
    protected SortDirection sortDirection = SortDirection.ASC;
    protected SortType sortType = SortType.SIMPLE;
    protected Paginator paginator;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public boolean needSorting() {
        return sortDirection != null && sortType != null;
    }

    public boolean shouldPaginate() {
        return paginator != null && paginator.getLimit() > 0 && paginator.getOffset() >= 0;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }
}
