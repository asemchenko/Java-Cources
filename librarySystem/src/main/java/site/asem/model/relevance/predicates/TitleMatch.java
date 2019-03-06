package site.asem.model.relevance.predicates;

import site.asem.model.entity.Publication;

import java.util.function.Predicate;

public class TitleMatch implements Predicate<Publication> {
    private String searchingTitle;

    public TitleMatch(String searchingTitle) {
        this.searchingTitle = searchingTitle.toLowerCase();
    }

    @Override
    public boolean test(Publication publication) {
        String t = publication.getTitle();
        // TODO optional
        if (t == null) {
            return false;
        }
        return t.contains(searchingTitle);
    }
}
