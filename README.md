# DSA Mastery

A structured collection of data structures and algorithms implemented in Java. Each topic includes a working implementation and a runnable demo.

## Structure

```
src/main/java/com/ayyoub/dsa/
  datastructures/
    linear/        — array, linkedlist, stack, queue
    hashbased/     — hashtable, hashset
    trees/         — binarytree, bst, avl, red-black, splay, heap, etc.
    graphs/        — representations, disjoint set
    advanced/      — bloom filter, skiplist, lru cache
  algorithms/
    searching/, sorting/, recursion/, graphalgorithms/,
    dynamicprogramming/, greedy/, backtracking/,
    stringalgorithms/, mathnumbertheory/, advanced/
```

## Running

```bash
# list available demos
mvn compile exec:java

# run a specific demo
mvn compile exec:java -Dexec.args="array"
```

## Progress

See [PROGRESS.md](./PROGRESS.md) for the full checklist.
