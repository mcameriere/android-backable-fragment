# android-backable-fragment
How to handle OnBackPressed in Fragment

The OnBackPressed is a method you override in the hosting Activity.

    public class MainActivity extends AppCompatActivity {

        @Override
        public void onBackPressed() {
            super.onBackPressed();
        }

    }

To handle the event on the fragment level, first create an interface

    public interface Backable {
        boolean onBackPressed();
    }

Make the Fragment implement the interface

    public class SimpleFragment extends Fragment implements Backable {

        @Override
        public boolean onBackPressed() {
            Toast.makeText(getContext(), "You clicked the back button", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
    
In the hosting Activity, delegate the work to the Fragment

    public class MainActivity extends AppCompatActivity {

        ...

        @Override
        public void onBackPressed() {
            boolean handled = false;
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            for (Fragment fragment: fragments) {
                if (fragment instanceof Backable) {
                    handled = ((Backable)fragment).onBackPressed();
                }
            }
            if (!handled) super.onBackPressed();
        }
    }
