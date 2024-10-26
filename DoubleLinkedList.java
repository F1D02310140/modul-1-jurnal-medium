public class DoubleLinkedList {
    Node head;
    Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public Integer length() {
        int count = 0;
        Node pointer = head;
        while (pointer != null) {
            count++;
            pointer = pointer.getNext();
        }
        return count;
    }

    public void scan() {
        Node pointer = head;
        while (pointer != null) {
            System.out.println("Character Name: " + pointer.charName);
            System.out.println("Stand Name: " + pointer.standName);
            System.out.println("Stand Abilities: " + pointer.abilities);
            System.out.println("Stand Power: " + pointer.power);
            System.out.println("Stand Speed: " + pointer.speed);
            System.out.println("Stand Range: " + pointer.range);
            System.out.println("Stand Total Rating: " + pointer.rating);
            System.out.println("--------------------------------------------");
            pointer = pointer.getNext();
        }
        System.out.println("\n");
    }

    public void add(Node newNode) {
        if (newNode == null) {
            System.out.println("Tidak bisa melakukan penambahan karena node baru adalah null.");
            return;
        }
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

    public void insertDataBefore(Node newNode, Node beforeNode) {
        if (newNode == null || beforeNode == null) {
            System.out.println("Node baru atau node yang ada tidak boleh null.");
            return;
        }
        if (head == beforeNode) {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.getNext() == beforeNode) {
                newNode.setNext(beforeNode);
                newNode.setPrevious(current);
                current.setNext(newNode);
                beforeNode.setPrevious(newNode);
                return;
            }
            current = current.getNext();
        }
    }

    public void delete(String charName) {
        if (charName == null || isEmpty()) {
            System.out.println("Node tidak dapat dihapus, daftar kosong atau nama null.");
            return;
        }

        // Jika node yang akan dihapus adalah head
        if (head.charName.equals(charName)) {
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            } else {
                tail = null; // Jika head sekarang null, tail juga harus null
            }
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.charName.equals(charName)) {
                Node prevNode = current.getPrevious();
                Node nextNode = current.getNext();

                if (prevNode != null) {
                    prevNode.setNext(nextNode);
                }

                if (nextNode != null) {
                    nextNode.setPrevious(prevNode);
                }

                if (current == tail) {
                    tail = prevNode; // Jika menghapus tail, update tail
                }
                return; // Node ditemukan dan dihapus
            }
            current = current.getNext();
        }
        System.out.println("Node dengan nama " + charName + " tidak ditemukan.");
    }

    public void merged(DoubleLinkedList linkedlist) {
        if (linkedlist == null || linkedlist.isEmpty()) {
            return; // Tidak ada yang perlu digabungkan
        }
        if (isEmpty()) {
            head = linkedlist.head;
            tail = linkedlist.tail;
        } else {
            tail.setNext(linkedlist.head);
            linkedlist.head.setPrevious(tail);
            tail = linkedlist.tail;
        }
    }

    public Node findNodeByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.charName.equals(name)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void swapCharacter(String name1, String name2) {
        Node firstChara = findNodeByName(name1);
        Node secChara = findNodeByName(name2);

        if (firstChara == null || secChara == null || firstChara == secChara) {
            System.out.println("Swap tidak bisa dilakukan, salah satu karakter tidak ditemukan.");
            return;
        }

        Node firstPrev = firstChara.getPrevious();
        Node firstNext = firstChara.getNext();
        Node secPrev = secChara.getPrevious();
        Node secNext = secChara.getNext();

        if (firstNext == secChara) {
            firstChara.setPrevious(secChara);
            firstChara.setNext(secNext);
            secChara.setPrevious(firstPrev);
            secChara.setNext(firstChara);

            if (firstPrev != null) {
                firstPrev.setNext(secChara);
            } else {
                head = secChara; // Update head jika pertama adalah head
            }

            if (secNext != null) {
                secNext.setPrevious(firstChara);
            } else {
                tail = firstChara; // Update tail jika kedua adalah tail
            }
        } else { // Non-adjacent swap
            if (firstPrev != null) {
                firstPrev.setNext(secChara);
            } else {
                head = secChara; // Update head jika pertama adalah head
            }

            if (secPrev != null) {
                secPrev.setNext(firstChara);
            } else {
                head = firstChara; // Update head jika kedua adalah head
            }

            firstChara.setPrevious(secPrev);
            firstChara.setNext(secNext);
            secChara.setPrevious(firstPrev);
            secChara.setNext(firstNext);

            if (firstNext != null) {
                firstNext.setPrevious(secChara);
            } else {
                tail = secChara; // Update tail jika pertama adalah tail
            }

            if (secNext != null) {
                secNext.setPrevious(firstChara);
            } else {
                tail = firstChara; // Update tail jika kedua adalah tail
            }
        }

        scan();
    }
}
