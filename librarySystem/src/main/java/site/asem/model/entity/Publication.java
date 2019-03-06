package site.asem.model.entity;

import java.util.List;

public abstract class Publication {
    private long id;
    private String title;
    /**
     * Represents universal decimal classifier
     *
     * @see <a href='https://en.wikipedia.org/wiki/Universal_Decimal_Classification'>Universal Decimal Classification</a>
     */
    private String udcID;
    private List<String> authors;
    private long pagesQuantity;
    private int publishYear;
    private List<String> tags;
    private List<Publication> references;

    public Publication(String title,
                       String udcID,
                       List<String> authors,
                       long pagesQuantity,
                       int publishYear,
                       List<String> tags,
                       List<Publication> references) {
        this.title = title;
        this.udcID = udcID;
        this.authors = authors;
        this.pagesQuantity = pagesQuantity;
        this.publishYear = publishYear;
        this.tags = tags;
        this.references = references;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUdcID() {
        return udcID;
    }

    public void setUdcID(String udcID) {
        this.udcID = udcID;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public long getPagesQuantity() {
        return pagesQuantity;
    }

    public void setPagesQuantity(long pagesQuantity) {
        this.pagesQuantity = pagesQuantity;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Publication> getReferences() {
        return references;
    }

    public void setReferences(List<Publication> references) {
        this.references = references;
    }
}