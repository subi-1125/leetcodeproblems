class Solution {
  public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Set<String> recSet = new HashSet<>(Arrays.asList(recipes));
    Map<String, Boolean> dp = new HashMap<>();

    // Initialize dp with supplies
    for (String supply : supplies) {
      dp.put(supply, true);
    }

    List<String> result = new ArrayList<>();
    for (String rec : recipes) {
      if (canCreate(rec, recSet, ingredients, dp, new HashSet<>(), recipes)) {
        result.add(rec);
      }
    }
    return result;
  }

  private boolean canCreate(String rec, Set<String> recSet, List<List<String>> ingredients,
      Map<String, Boolean> dp, Set<String> visited, String[] recipes) {
    if (dp.containsKey(rec))
      return dp.get(rec);
    if (!recSet.contains(rec))
      return false;
    if (visited.contains(rec))
      return false; // Cycle detected

    visited.add(rec);

    int index = Arrays.asList(recipes).indexOf(rec);
    for (String ing : ingredients.get(index)) {
      if (!canCreate(ing, recSet, ingredients, dp, visited, recipes)) {
        dp.put(rec, false);
        return false;
      }
    }

    visited.remove(rec);
    dp.put(rec, true);
    return true;
  }
}