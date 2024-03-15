# Artificial Intelligence



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
