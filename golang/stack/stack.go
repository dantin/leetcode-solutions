package stack

type Stack struct {
	top    *node
	length int
}

type node struct {
	value interface{}
	prev  *node
}

// Create a new stack
func New() *Stack {
	return &Stack{nil, 0}
}

// Return the number of items in the stack
func (s *Stack) Len() int {
	return s.length
}

// IsEmpty check whether a stack is empty
func (s *Stack) IsEmpty() bool {
	return s != nil && s.length == 0
}

// View the top item on the stack
func (s *Stack) Peek() interface{} {
	if s.length == 0 {
		return nil
	}
	return s.top.value
}

// Pop the top item of the stack and return it
func (s *Stack) Pop() interface{} {
	if s.length == 0 {
		return nil
	}

	n := s.top
	s.top = n.prev
	s.length--
	return n.value
}

// Push a value onto the top of the stack
func (s *Stack) Push(value interface{}) {
	n := &node{value, s.top}
	s.top = n
	s.length++
}
