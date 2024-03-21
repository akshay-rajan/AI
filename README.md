# Artificial Intelligence

Artificial Intelligence (AI) refers to the simulation of human intelligence in machines that are programmed to think and learn like humans. It involves the development of computer systems capable of performing tasks that would typically require human intelligence, such as visual perception, speech recognition, decision-making, and problem-solving.

AI encompasses various subfields, including machine learning, natural language processing, computer vision, robotics, and expert systems. These technologies enable machines to analyze large amounts of data, recognize patterns, make predictions, and adapt to changing circumstances.

AI has applications in numerous industries, including healthcare, finance, transportation, and entertainment. It has the potential to revolutionize the way we live and work, improving efficiency, accuracy, and decision-making processes.

### Terminology

Terms | Meaning
--- | ---
Agent | Entity that perceives its environment and acts upon that environment
State | A configuration of the agent and its environment
**Initial State** | The state in which the agent begins
**Actions** | Choices that can be made in a state: ACTIONS(s) returns the set of actions that can be executed in the state 's'
**Transition Model** | A description of what state results from any applicable action in any state: RESULT(s, a) returns the state resulting from performing action 'a' in state 's'
State Space | Set of all states reachable from the initial state by any sequence of actions.
**Goal Test** | A way to determine whether a given state is a goal state
**Path Cost** | Numerical cost associated with a given path
Optimal Solution | A solution that has the the lowest path cost among all other solutions

### Defining a Problem

In order to define a problem in the context of artificial intelligence, specify the following components:

1. State Space: The set of all possible states that the problem can be in.
2. Initial State: The starting state of the problem.
3. Goal State: The desired state that the problem should reach.
4. Actions Available: The set of possible actions that can be taken in each state.

### Production Rules

Production rules consists of
1. A Set of Rules: A collection of condition-action pairs that dictate the behavior of the system.
2. Knowledge Databases: A structured repository of facts and information that the system uses to make decisions.
3. Control Strategies: The methods used to determine which rule to apply when multiple rules are applicable.
4. Rule Applier: The mechanism that applies the rules to the knowledge database based on the control strategies.

### Node
A node is a data structure that keeps track of
- a state
- a parent (the node that generated this node)
- an action (action applied to parent to get node)
- a path cost (from initial state to node)

### BFS vs DFS


| Criteria            | Breadth-First Search (BFS)                                 | Depth-First Search (DFS)                                     |
|---------------------|------------------------------------------------------------|--------------------------------------------------------------|
| Definition          | Expands nodes level by level from the start node outward.  | Expands nodes depth-wise, exploring as far as possible along each branch before backtracking.|
| Order of Expansion  | Expands nodes level by level from the start node outward.  | Expands nodes depth-wise, exploring as far as possible along each branch before backtracking.|
| Data Structure      | Uses a queue data structure to store nodes for expansion.  | Uses a stack data structure (or recursion) for node traversal.|
| Memory Usage        | Typically uses more memory due to storing all nodes at each level. | Generally uses less memory because it only stores a path from the start node to the current node. |
| Completeness        | Guarantees finding a solution if one exists in finite search spaces. | Guarantees finding a solution if one exists in finite search spaces. |
| Optimality          | Ensures the shortest path is found in terms of number of edges for unweighted graphs. | Does not guarantee the shortest path; may find a solution that is not optimal in terms of path length. |
| Implementation      | Implemented iteratively using a queue for node expansion.   | Implemented recursively (or using a stack) for node traversal. |
| Use Cases           | Well-suited for finding shortest paths, puzzle solving, and exploring neighbor nodes uniformly. | Suitable for topological sorting, maze solving, and searching large trees or graphs. |

