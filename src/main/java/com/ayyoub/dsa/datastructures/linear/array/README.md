# DynamicArray

## Complexity, DynamicArray

| Method              | Time (avg)     | Time (worst)  | Space |
|---------------------|:--------------:|:-------------:|:-----:|
| `get(index)`        | O(1)            | O(1)          | O(1)  |
| `set(index, val)`   | O(1)            | O(1)          | O(1)  |
| `add(val)`          | O(1) amortized  | O(n) (resize) | O(1)  |
| `add(index, val)`   | O(n)            | O(n)          | O(1)  |
| `remove(index)`     | O(n)            | O(n)          | O(1)  |
| `size()` / `capacity()` | O(1)        | O(1)          | O(1)  |

**Memory hook**: only `get`, `set`, `size`, `capacity` are true O(1) — anything that touches an index in the *middle* (`add(index,...)`, `remove(index)`) has to shift, so it's O(n). `add(val)` at the end is O(1) *amortized* only — a single call can hit O(n) when it triggers `resize()`.