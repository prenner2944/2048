package edu.purdue.prenner.myapplication;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

/**
 * MainActivity class that serves the same purpose to an Android app as the heart does to humans
 * Basically, the most important class of the app
 *
 * @author Sahil Pujari (pujari@purdue.edu)
 * @author Tori Shurman (vshurman@purdue.edu)
 */
public class MainActivity extends AppCompatActivity {

    //The context of the app. Context is used to refer to certain resources of the app outside of
    //the MainActivity class
    private static Context mContext;

    /**
     * Get the context of the app
     * @return the context of the app
     */
    public static Context getAppContext() {
        return mContext;
    }

    //An object of our TwentyFortyEight class
    private TwentyFortyEight twentyFortyEight;

    //An object of CustomGrid class
    private CustomGrid customGrid;

    //The score box text in the app
    private TextView scoreBox;

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.
     *
     * @see #onSaveInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        twentyFortyEight = new TwentyFortyEight(4);
        customGrid = new CustomGrid();

        GridView grid = (GridView) findViewById(R.id.mainGrid);
        scoreBox = (TextView) findViewById(R.id.scoreBox);

        grid.setAdapter(customGrid);

        //TODO: Call the reset() method of your TwentyFortyClass to reset the board when the app
        //first starts
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     *
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     *
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     *
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     *
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     *
     * @return You must return true for the menu to be displayed;
     *         if you return false it will not be shown.
     *
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     *
     * @return boolean Return false to allow normal menu processing to
     *         proceed, true to consume it here.
     *
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Method invoked when the Up button is pressed
     *
     * @param view - the UI of the app
     */
    public void upAction(View view) {
        twentyFortyEight.moveUp();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        scoreBox.setText(twentyFortyEight.getScore());
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
    }

    /**
     * Method invoked when the Down button is pressed
     *
     * @param view - the UI of the app
     */
    public void downAction(View view) {
        twentyFortyEight.moveDown();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        scoreBox.setText(twentyFortyEight.getScore());
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
    }

    /**
     * Method invoked when the Left button is pressed
     *
     * @param view - the UI of the app
     */
    public void leftAction(View view) {
        twentyFortyEight.moveLeft();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        scoreBox.setText(twentyFortyEight.getScore());
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
    }

    /**
     * Method invoked when the Right button is pressed
     *
     * @param view - the UI of the app
     */
    public void rightAction(View view) {
        twentyFortyEight.moveRight();
        customGrid.updateGrid(twentyFortyEight.getBoard());
        scoreBox.setText(twentyFortyEight.getScore());
        //TODO 1: Use the moveUp method of TwentyFortyEight to implement the logic to be performed
        //TODO 2: Call the updateGrid method of CustomGrid and pass your TwentyFortyEight's board
        //as parameter
        //TODO 3: Use the scoreBox.setText() method to update the value of the score box based on
        //the score from your TwentyFortyEight
    }
}