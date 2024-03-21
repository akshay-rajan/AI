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

## Search Strategies

1. **Breadth-First Search (BFS)**:
   ```
    BFS(initial_state)
        If the initial state is the goal, return success
        Create NODE-LIST and enqueue the initial state into NODE-LIST
        
        While queue is not empty:
            Dequeue the first element 'E' from NODE-LIST.
            If NODE-LIST is empty, return failure
            For each way a rule can match the state described in E:
                Apply the rule to generate a state
                If it is the goal state, return this state
                Else, enqueue the new state to the NODE-LIST
   ```

2. **Depth-First Search (DFS)**:
   ```
    DFS(initial_state):
        If the inital state is goal, return success
        Repeat until success or failure is returned:
            Generate a successor E of the inital state
            Call DFS with E as the initial state
            If success is retured, signal success. Else, continue in this loop.
   ```

3. **Iterative Deepening Search (IDS)**:
   ```
    IDS(start_node, depth_limit):
        Set SEARCH-DEPTH to 0
        While SEARCH-DEPTH < depth_limit:
            Conduct DFS upto SEARCH-DEPTH
            If solution is found, return success
            Else, increment the SEARCH-DEPTH
        If no solution is found, return failure
   ```

4. **Best First Search (BFS)**:
   ```
    BFS(initial_state):
        Initialize an empty priority queue OPEN.
        Enqueue initial_state to priority queue with priority based on heuristic value.
        Until goal is found or OPEN is empty, do:
            Pick the best node in OPEN
            Generate its successors
            For each successor, do:
                Evaluate the node if it is not already been evaluated
                Enqueue the successor to OPEN
        If no solution is found, return failure.
   ```

5. **Hill Climbing**:
   ```
   HillClimbing(initial_state):
       If the initial_state is the goal state, return success
       Else, continue with the initial_state as current_state
       Loop until a solution is found or there are no new operators to apply to the current_state:
           Select an operator and produce a new state
           Evaluate the new state
                If the new state is goal, return success
                If the new_state is better than current_state, make it current_state
                Else continue the loop.
   ```

6. **Steepest Ascent Hill Climbing**:
   ```
    SteepestAscentHillClimbing(initial_state):
        Evaluate the inital_state. If it is the goal state, return success.
        Else continue with the initial_state as current_state
        Loop until a solution is found or a complete iteration produces no new changes to the state:
            For each rule that matches the current_state:
                Let SUCC be a state such that all successors of the current_state is better than SUCC
                Apply the rule and generate a new_state
                Evaluate new_state
                    If new_state is the goal, return success
                    Else, if new_state is better than SUCC, set SUCC as new_state
                If SUCC is better than current_state, set current_state to SUCC

   ```

7. **A\* Search**:
   ```
   AStar(start_node, goal_node):
       Initialize an empty priority queue.
       Enqueue start_node into the priority queue with priority f(start_node) = g(start_node) + h(start_node).
       Mark start_node as visited and set its g-value to 0.
       
       while priority queue is not empty:
           Dequeue a node from the priority queue.
           Process the node.
           
           if node == goal_node:
               return "Goal found"
               
           for each neighbor of the dequeued node:
               if neighbor is not visited or g-value is lower:
                   Mark neighbor as visited.
                   Update neighbor's g-value to g(neighbor) = g(node) + cost(node, neighbor).
                   Enqueue neighbor into the priority queue with priority f(neighbor) = g(neighbor) + h(neighbor).
       return "Goal not found"
   ```

8. **Simulated Annealing**:
   ```
   SimulatedAnnealing(start_state, temperature, cooling_rate):
       current_state = start_state
       
       while temperature > 0:
           new_state = generate_random_neighbor(current_state)
           energy_diff = evaluation(new_state) - evaluation(current_state)
           
           if energy_diff < 0 or random(0, 1) < exp(-energy_diff / temperature):
               current_state = new_state
           
           temperature *= cooling_rate
       
       return current_state
   ```

### BFS vs DFS

| Criteria            | Breadth-First Search (BFS)                                 | Depth-First Search (DFS)                                     |
|---------------------|------------------------------------------------------------|--------------------------------------------------------------|
| Order of Expansion  | Expands nodes level by level from the start node outward.  | Expands nodes depth-wise, exploring as far as possible along each branch before backtracking.|
| Data Structure      | Uses a queue data structure to store nodes for expansion.  | Uses a stack data structure (or recursion) for node traversal.|
| Memory Usage        | Typically uses more memory due to storing all nodes at each level. | Generally uses less memory because it only stores a path from the start node to the current node. |
| Completeness        | Guarantees finding a solution if one exists in finite search spaces. | Guarantees finding a solution if one exists in finite search spaces. |
| Optimality          | Ensures the shortest path is found in terms of number of edges for unweighted graphs. | Does not guarantee the shortest path; may find a solution that is not optimal in terms of path length. |
| Implementation      | Implemented iteratively using a queue for node expansion.   | Implemented recursively (or using a stack) for node traversal. |
| Use Cases           | Well-suited for finding shortest paths, puzzle solving, and exploring neighbor nodes uniformly. | Suitable for topological sorting, maze solving, and searching large trees or graphs. |


### Hill Climbing vs Steepest Ascent Hill Climbing

| Criteria                     | Hill Climbing                                               | Steepest Ascent Hill Climbing                                |
|------------------------------|-------------------------------------------------------------|--------------------------------------------------------------|
| Search Strategy              | Local search algorithm that iteratively improves the current solution by moving to a neighboring state. | Local search algorithm that always selects the best among all neighboring states for improvement. |
| Heuristic Evaluation         | Uses a heuristic function to evaluate neighboring states and chooses one that improves the current solution. | Utilizes the same heuristic function but always selects the state that yields the highest improvement. |
| Decision Making              | Selects a neighboring state that improves the current solution, even if it does not yield the best possible improvement. | Always chooses the state that provides the steepest ascent, ensuring the best possible improvement at each step. |
| Memory Usage                 | Typically requires less memory as it only needs to store the current state and its neighbors. | Requires slightly more memory due to the need to evaluate all neighboring states for the steepest ascent. |
| Completeness                 | Not guaranteed to find the global optimum; may get stuck in local optima. | Not guaranteed to find the global optimum; may get stuck in local optima. |
| Convergence                  | Can converge quickly to a local optimum but may not be the global optimum. | Tends to converge more slowly than basic hill climbing but may reach a better local optimum. |
| Backtracking                 | Does not perform backtracking; may get stuck in local optima.   | Does not perform backtracking; may get stuck in local optima. |
| Use Cases                    | Suitable for optimization problems where finding a good solution quickly is more important than guaranteeing the best solution. | Useful when the goal is to reach a better local optimum than basic hill climbing, even if it takes more iterations. |

