package site.asem.model.relevance.predicates;

import org.jetbrains.annotations.NotNull;
import site.asem.model.entity.Publication;

import java.util.Objects;
import java.util.function.Predicate;

public class AuthorMatch implements Predicate<Publication> {
    @NotNull
    private String lookingAuthor;

    public AuthorMatch(@NotNull String lookingAuthor) {
        Objects.requireNonNull(lookingAuthor);
        this.lookingAuthor = lookingAuthor.toLowerCase();
    }

    @Override
    public boolean test(@NotNull Publication publication) {
        var authors = publication.getAuthors();
        // TODO optional?
        if (authors == null) {
            return false;
        }
        // TODO stream
        for (String author : publication.getAuthors()) {
            if (author != null && author.toLowerCase().contains(lookingAuthor)) {
                return true;
            }
        }
        return false;
    }
}
