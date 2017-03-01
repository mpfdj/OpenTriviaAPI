package snippets;

public class Bar {

    public int foo(MyEnum value) {
        switch (value) {
            case A: return 1;
            case B: return 2;
        }
        throw new IllegalArgumentException("Do not know how to handle " + value);
    }
}