package snippets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.powermock.reflect.Whitebox.setInternalState;

// Mocking an enumeration here!!!
// http://stackoverflow.com/questions/5323505/mocking-java-enum-to-add-a-value-to-test-fail-case
// https://github.com/powermock/powermock/wiki/GettingStarted

@RunWith(PowerMockRunner.class)
public class PowerMockBarTest {

    private Bar bar;

    @Before
    public void createBar() {
        bar = new Bar();
    }

    @Test(expected = IllegalArgumentException.class)
    @PrepareForTest(MyEnum.class)
    public void unknownValueShouldThrowException() throws Exception {
        MyEnum C = mock(MyEnum.class);
        setInternalState(C, "name", "C");
        setInternalState(C, "ordinal", 2);

        mockStatic(MyEnum.class);
        when(MyEnum.values()).thenReturn(new MyEnum[]{MyEnum.A, MyEnum.B, C});

        bar.foo(C);
    }

    @Test
    public void AShouldReturn1() {
        assertThat(bar.foo(MyEnum.A), is(1));
    }

    @Test
    public void BShouldReturn2() {
        assertThat(bar.foo(MyEnum.B), is(2));
    }
}