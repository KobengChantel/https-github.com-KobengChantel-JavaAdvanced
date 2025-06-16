package ch10;

/**
 * The Poof class contains a method calcWhuffie marked as final.
 * This means the method cannot be overridden by any subclass.
 */
class Poof {
  /**
   * This final method performs important calculations.
   * Marking it final ensures that subclasses cannot change its behavior,
   * preserving the intended logic.
   */
  final void calcWhuffie() {
    // important things
    // that must never be overridden
  }
}
