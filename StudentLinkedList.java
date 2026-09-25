class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
    }
}

public class StudentLinkedList {
    Node head;

    // Add a student record
    void add(Student s) {
        if (search(s.id) != null) {
            System.out.println("Error: Student ID already exists!");
            return;
        }
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Student added successfully!");
    }

    // Search a student by ID
    Student search(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.id == id) return temp.data;
            temp = temp.next;
        }
        return null;
    }

    // Update a student record
    void update(int id, String name, String programme, double marks) {
        Student s = search(id);
        if (s == null) {
            System.out.println("Error: Student not found!");
            return;
        }
        s.name = name;
        s.programme = programme;
        s.marks = marks;
        System.out.println("Student updated successfully!");
    }

    // Delete a student record
    Student delete(int id) {
        Node temp = head, prev = null;
        while (temp != null) {
            if (temp.data.id == id) {
                if (prev == null) head = temp.next;
                else prev.next = temp.next;
                System.out.println("Student deleted successfully!");
                return temp.data;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("Error: Student not found!");
        return null;
    }

    // Display all records
    void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}