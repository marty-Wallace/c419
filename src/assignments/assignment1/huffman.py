import queue

class HuffNode(object):
    def __init__(self, left=None, right=None, char='', value=0):
        self.left = left
        self.right = right
        self.char = char
        self.value = value

    def __lt__(self, other):
        return self.value < other.value

    def __eq__(self, other):
        return self.value == other.value


freq = [('space', 192), ('e', 128), ('o', 86), ('i', 82), ('t', 72), ('s', 72), ('n', 70), ('r', 58), ('a', 58),
        ('l', 54), ('c', 42), ('h', 40), ('m', 36), ('p', 30), ('u', 29), ('y', 25), ('f', 25), ('d', 24), ('b', 23),
        ('w', 16), ('v', 13), ('P', 11), ('k', 10), ('q', 9), ('.', 9), ('newline', 7), (',', 7), ('g', 6), ('"', 6),
        ('0', 6), ('I', 5), ('T', 5), ('N', 4), ('S', 3), ('1', 3), ('j', 2), ('z', 2), ('C', 2), ('M', 2), ('[', 2),
        (']', 2), ('x', 1), ('W', 1), ('F', 1), ('$', 1), ('9', 1), ('7', 1), ('2', 1), ('3', 1), ('=', 1), (':', 1),
        ('U', 1)]

def build_tree(f):
    p = queue.PriorityQueue()
    for v in f:
        p.put(HuffNode(None, None, v[0], v[1]))

    while p.qsize() > 1:
        left, right = p.get(), p.get()
        new_node = HuffNode(left, right, '', left.value + right.value)
        p.put(new_node)
    return p.get()

# Recursively walk the tree down to the leaves,
# assigning a code value to each symbol
def walk_tree(current_node, prefix="", code=[], level=0, parent_value=0):
    code.append((prefix, current_node.char, level, current_node.value))
    print("Prefix: %s   Char: %s    Level: %d   Value: %d   Parent Value: %d"  % (prefix, current_node.char, level, current_node.value, parent_value) )
    _ = input()
    if not current_node.char:
        walk_tree(current_node.left, prefix + "0", code=code, level=level+1, parent_value=current_node.value)
    if not current_node.char:
        walk_tree(current_node.right, prefix + "1", code=code, level=level+1, parent_value=current_node.value)


code= []
node = build_tree(freq)
walk_tree(node, code=code)

code =sorted(code, key=lambda x: (x[2], x[0]))

print(code)

last = -1
for a in code:
    if last != a[2]:
        print("\n", a[0], "'" + a[1] + "'", a[3], end='\t')
    else:
        print(a[0], "'" + a[1] + "'", a[3], end='\t')
    last = a[2]
print()


sum = 0
total = 0
for a in code:
    if a[1]:
        sum += len(a[0]) * a[3]
        total += a[3]

print("Total bytes without Huffman Encoding: " + str(total * 7))
print("Total bytes with Huffman Encoding: " + str(sum))
print("Percent size of Huffman vs uncompressed: %.2f" % (sum / (total * 7) *  100))
