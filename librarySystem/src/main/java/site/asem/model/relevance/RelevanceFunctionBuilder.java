package site.asem.model.relevance;

import org.jetbrains.annotations.NotNull;
import site.asem.model.entity.Publication;
import site.asem.model.relevance.predicates.AuthorMatch;
import site.asem.model.relevance.predicates.TagMatch;
import site.asem.model.relevance.predicates.TitleMatch;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RelevanceFunctionBuilder {
    private List<Predicate<Publication>> predicates = new LinkedList<>();
    private RelevanceFunction function;

    public RelevanceFunctionBuilder(HttpServletRequest req) {
        createAllPredicates(req);
        makeFunction();
    }

    public RelevanceFunction getFunction() {
        return function;
    }

    private void createAllPredicates(@NotNull HttpServletRequest req) {
        // TODO refactor it
        Map<String, String[]> params = req.getParameterMap();
        for (var entry : params.entrySet()) {
            switch (entry.getKey()) {
                case "allAttributes":
                    createPredicates(entry.getValue(), TitleMatch::new);
                    createPredicates(entry.getValue(), AuthorMatch::new);
                    createPredicates(entry.getValue(), TagMatch::new);
                    break;
                case "title":
                    createPredicates(entry.getValue(), TitleMatch::new);
                    break;
                case "author":
                    createPredicates(entry.getValue(), AuthorMatch::new);
                    break;
                case "tag":
                    createPredicates(entry.getValue(), TagMatch::new);
                    break;
            }
        }
    }

    private void createPredicates(String[] values,
                                  Function<String, Predicate<Publication>> creator) {
        predicates.addAll(Arrays.stream(values).map(creator).collect(Collectors.toList()));
    }

    private void makeFunction() {
        function = new RelevanceFunction(predicates);
    }
}
