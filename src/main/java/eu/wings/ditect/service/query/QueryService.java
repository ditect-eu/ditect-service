package eu.wings.ditect.service.query;

/**
 * Perform any database query.
 *
 * @param <C> the search criteria type.
 * @param <R> the result type.
 */
public interface QueryService<C, R> {

  /**
   * Search rely on given criteria.
   *
   * @param criteria the search criteria
   * @return the result
   */
  R search(C criteria);
}
