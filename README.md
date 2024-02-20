# Artificial Intelligence

### Terminology

Terms | Meaning
--- | ---
Agent | Entity that perceives its environment and acts upon that environment
State | A configuration of the agent and its environment
Initial State | The state in which the agent begins
Actions | Choices that can be made in a state: ACTIONS(s) returns the set of actions that can be executed in the state 's'
Transition Model | A description of what state results from any applicable action in any state: RESULT(s, a) returns the state resulting from performing action 'a' in state 's'
State Space | Set of all states reachable from the initial state by any sequence of actions.
Goal Test | A way to determine whether a given state is a goal state
Path Cost | Numerical cost associated with a given path
Optimal Solution | A solution that has the the lowest path cost among all other solutions

### Node
A node is a data structure that keeps track of
- a state
- a parent (the node that generated this node)
- an action (action applied to parent to get node)
- a path cost (from initial state to node)
