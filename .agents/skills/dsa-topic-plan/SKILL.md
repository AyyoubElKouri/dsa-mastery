---
name: dsa-topic-plan
description: Generates a Theory/Build/Practice study-and-implementation plan for one topic from the user's Java "DSA Mastery" repo (package com.ayyoub.dsa, structured as datastructures/... and algorithms/...). The Build section always includes a full compilable class skeleton — every public method stubbed with a `// Implementation for ...` comment and a placeholder return, plus stubbed private helpers — not just a bullet list of methods. Always use this skill whenever the user says they want to work on, start, tackle, learn, or build a specific data structure or algorithm (e.g. "let's do arrays", "help me with AVL tree", "what should I build for quicksort", "next topic", "I'm starting on segment tree today"), even if they don't ask for a "plan" or "skeleton" by name — a bare topic name in this context is a request for this output. Do not give an ad-hoc explanation instead of using this skill when the topic is one of the ~60 items in references/checklist.md.
---

# DSA Topic Plan

Produces one topic's worth of theory + implementation + practice guidance, scaled to
that topic's time budget, in the fixed format the user has already settled on (the
Array plan below is the canonical example — match its depth and tone, not just its
headers).

## Workflow

1. **Identify the topic.** Match the user's phrasing against `references/checklist.md`.
   - If it's ambiguous between variants (e.g. "queue" → simple/circular/deque/priority,
     "heap" → min/max), cover the general case as the main build and name the variants
     as a one-line "also worth doing" note rather than stopping to ask — momentum matters
     more than precision here.
   - If the topic isn't in the checklist at all, say so and ask which checklist item they mean.
2. **Look up the hour budget and folder path** from the checklist reference.
3. **Scale depth to the budget:**
   - ≤2h topics (Linear Search, Euclidean GCD, basic sorts): skip the complexity table,
     keep theory to 2-3 bullets, one implementation file, 1-2 practice problems.
   - 3-5h topics (Array, Stack, BST, most algorithms): full format as in the example below.
   - 6h+ topics (AVL, Segment Tree, Dijkstra, FFT): add a "gotchas" subsection under Build
     for the parts people typically get wrong (e.g. rotation cases, off-by-one in range
     queries) — these topics earn the extra depth.
4. **Output in this structure:**

```
## <Topic Name> — <hours from checklist>

### Theory (~<fraction of budget>)
- concept bullets — mechanism, not just definition
- complexity table if more than one operation/variant is meaningful to compare

### Build (~<fraction of budget>)
<folder path>/
├── <ClassName>.java       — from-scratch, no java.util shortcuts for the core logic
└── <ClassName>Demo.java

<the full public-interface skeleton — see "Skeleton format" below, always include it
in full, never just describe the methods in prose>

- one-line rationale under the skeleton only for anything non-obvious (a private
  helper's purpose, a tricky invariant) — not a restatement of what each method is
- reminder: register the demo in Main's static block (see entry-point convention)

### Practice (~<fraction of budget>)
- 2-3 problems max, each with a one-line reason it was picked (not just a title dump)
```

### Skeleton format

The skeleton is not optional and is not a bullet list — it's a compilable class stub,
every time, formatted exactly like this:

```java
/**
 * <one-sentence description of what the structure/algorithm does>
 * <ClassName>
 * @param <T>          // omit if not generic
 */
public class <ClassName><<T>> {

    public <ReturnType> <methodName>(<params>) {
        // Implementation for <what this method does>
        return <default: null/0/false/appropriate default>;
    }

    // ... one stub per public method, void methods get no return line

    private <ReturnType> <helperName>(<params>) {
        // Implementation for <what this helper does>
    }
}
```

Rules for the skeleton:
- **Every public method the structure needs** gets a stub — not a curated subset.
  Cover the full interface: accessors, mutators, size/state queries, and anything
  the "Practice" problems below will call.
- **Method bodies are empty except a `// Implementation for <...>` comment** and, for
  non-void methods, a placeholder return (`return null;`, `return 0;`, `return false;`,
  or a sensible zero-value for the type) — never real logic, never a partial
  implementation.
- **Private helpers appear too** (e.g. `resize()`, `rotateLeft()`, `heapifyUp()`) with
  the same comment-stub treatment — these are exactly the methods worth stubbing
  because their existence signals the algorithm's shape even before they're filled in.
- **No constructors, fields, or imports need to be shown** unless a field's presence
  materially changes how the interface reads (rare — skip by default).
- Match Java conventions: `<T>` generics where the structure is generic, `@param <T>`
  in the Javadoc, standard brace style.

Budget fractions: roughly 30-40% theory, 45-55% build, 15-20% practice — adjust per topic
(a topic like "Recursion basics" is nearly all theory+small build; "Sudoku Solver" is
almost all build+practice).

## Canonical example (match this bar)

**Input:** "So for the first one, Arrays, what should I learn and build?"

**Output:**

## Array — 3-4h

### Theory (30-45 min)
- Static array: fixed size, contiguous memory, why that gives O(1) random access
  (`base_address + index * element_size`)
- Dynamic array: amortized O(1) append via multiplicative growth (1.5x/2x) vs why
  additive growth would make it O(n) per append
- Cache locality: why arrays beat pointer-chasing structures in practice despite
  equal Big-O

| Operation | Static Array | Dynamic Array (amortized) |
|---|---|---|
| Access by index | O(1) | O(1) |
| Search (unsorted) | O(n) | O(n) |
| Insert at end | O(1)/N/A | O(1) amortized |
| Insert at index | O(n) | O(n) |
| Delete at index | O(n) | O(n) |
| Resize | N/A | O(n) when triggered |

### Build (2-2.5h)
```
datastructures/linear/array/
├── DynamicArray.java
└── DynamicArrayDemo.java
```

```java
/**
 * A dynamic array implementation that can grow and shrink in size.
 * DynamicArray
 * @param <T>
 */
public class DynamicArray<T> {

    public T get(int index) {
        // Implementation for getting an element at a specific index
        return null;
    }

    public void set(int index, T element) {
        // Implementation for replacing the element at a specific index
    }

    public void add(T element) {
        // Implementation for adding an element to the end, resizing if full
    }

    public void add(int index, T element) {
        // Implementation for inserting an element at a specific index, shifting elements right
    }

    public void remove(int index) {
        // Implementation for removing the element at a specific index, shifting elements left
    }

    public int size() {
        // Implementation for getting the current number of elements
        return 0;
    }

    public int capacity() {
        // Implementation for getting the current backing array length
        return 0;
    }

    private void resize() {
        // Implementation for growing the backing array when capacity is reached
    }
}
```
- `size()` and `capacity()` are both exposed and kept distinct — that's the whole point
  of the exercise
- `resize()` is private but stubbed anyway — its presence is the reminder that append
  isn't truly O(1), it's amortized

### Practice (30-45 min)
- Two Sum — baseline, surfaces the hashmap-vs-array tradeoff early
- Rotate Array (in-place, O(1) space) — shifting/index-arithmetic workout
- Merge Sorted Array (in-place from the back) — classic direction-of-iteration trap

## Notes

- The user tracks progress in `PROGRESS.md` and runs demos via a `Main` registry
  (`mvn compile exec:java -Dexec.args="<key>"`) — the Build section should produce output
  consistent with that convention (a `TopicDemo.java` with a static `run()`), not a
  standalone `main()` unless the user has said they dropped the registry pattern.
- The skeleton is always shown in full — never replace it with a description of the
  methods, and never abbreviate it with "// ...rest of methods..." once started.
- Don't pad the Theory or Practice sections. If a topic only needs 3 theory bullets,
  give 3, not 6. The skeleton itself is where the length is supposed to live.
- This is a personal mastery repo aimed at principal-engineer-level interview depth —
  favor precision and "why," not encyclopedic coverage.