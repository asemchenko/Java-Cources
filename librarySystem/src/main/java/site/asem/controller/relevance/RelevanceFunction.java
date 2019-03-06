package site.asem.controller.relevance;

import org.jetbrains.annotations.NotNull;
import site.asem.model.entity.Publication;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class RelevanceFunction implements Function<Publication, Long> {
    private List<Predicate<Publication>> predicates;

    public RelevanceFunction(List<Predicate<Publication>> predicates) {
        this.predicates = new LinkedList<>(predicates);
    }

    public void addPredicate(@NotNull Predicate<Publication> p) {
        Objects.requireNonNull(p);
        predicates.add(p);
    }

    /**
     * Calculates how many predicates satisfy publication.
     *
     * @param publication publication for testing
     * @return relevance coefficient
     */
    @Override
    public Long apply(Publication publication) {
        long value = predicates.stream().filter(p -> p.test(publication)).count();
        return value;
    }
}
