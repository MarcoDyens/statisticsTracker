import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class PlayerRow {

    private String firstName;
    private String lastName;
    private int number;



    public Button getAddAssists() {
        assistsModifier();
        return addAssists;

    }

    public void setAddAssists(Button addAssists) {
        assistsModifier();
        this.addAssists = addAssists;
    }

    public Button getRemoveAssists() {
        assistsModifier();
        return removeAssists;
    }

    public void setRemoveAssists(Button removeAssists) {
        assistsModifier();
        this.removeAssists = removeAssists;
    }

    public Label getTotalAssists() {
        assistsModifier();
        return totalAssists;
    }

    public void setTotalAssists(Label totalAssists) {
        assistsModifier();
        this.totalAssists = totalAssists;
    }

    public Button getAddShots() {
        shotsModifier();
        return addShots;
    }

    public void setAddShots(Button addShots) {
        shotsModifier();
        this.addShots = addShots;
    }

    public Button getRemoveShots() {
        shotsModifier();
        return removeShots;
    }

    public void setRemoveShots(Button removeShots) {
        shotsModifier();
        this.removeShots = removeShots;
    }

    public Label getTotalShots() {
        shotsModifier();
        return totalShots;
    }

    public void setTotalShots(Label totalShots) {
        shotsModifier();
        this.totalShots = totalShots;
    }

    public Button getAddCrosses() {
        crossesModifier();
        return addCrosses;
    }

    public void setAddCrosses(Button addCrosses) {
        crossesModifier();
        this.addCrosses = addCrosses;
    }

    public Button getRemoveCrosses() {
        crossesModifier();
        return removeCrosses;
    }

    public void setRemoveCrosses(Button removeCrosses) {
        crossesModifier();
        this.removeCrosses = removeCrosses;
    }

    public Label getTotalCrosses() {
        crossesModifier();
        return totalCrosses;
    }

    public void setTotalCrosses(Label totalCrosses) {
        crossesModifier();
        this.totalCrosses = totalCrosses;
    }

    public Button getAddDribbles() {
        dribblesModifier();
        return addDribbles;
    }

    public void setAddDribbles(Button addDribbles) {
        dribblesModifier();
        this.addDribbles = addDribbles;
    }

    public Button getRemoveDribbles() {
        dribblesModifier();
        return removeDribbles;
    }

    public void setRemoveDribbles(Button removeDribbles) {
        dribblesModifier();
        this.removeDribbles = removeDribbles;
    }

    public Label getTotalDribbles() {
        dribblesModifier();
        return totalDribbles;
    }

    public void setTotalDribbles(Label totalDribbles) {
        dribblesModifier();
        this.totalDribbles = totalDribbles;
    }

    public Button getAddPasses() {
        passesModifier();
        return addPasses;
    }

    public void setAddPasses(Button addPasses) {
        passesModifier();
        this.addPasses = addPasses;
    }

    public Button getRemovePasses() {
        passesModifier();
        return removePasses;
    }

    public void setRemovePasses(Button removePasses) {
        passesModifier();
        this.removePasses = removePasses;
    }

    public Label getTotalPasses() {
        passesModifier();
        return totalPasses;
    }

    public void setTotalPasses(Label totalPasses) {
        passesModifier();
        this.totalPasses = totalPasses;
    }

    public Button getAddTouches() {
        touchesModifier();
        return addTouches;
    }

    public void setAddTouches(Button addTouches) {
        touchesModifier();
        this.addTouches = addTouches;
    }

    public Button getRemoveTouches() {
        touchesModifier();
        return removeTouches;
    }

    public void setRemoveTouches(Button removeTouches) {
        touchesModifier();
        this.removeTouches = removeTouches;
    }

    public Label getTotalTouches() {
        touchesModifier();
        return totalTouches;
    }

    public void setTotalTouches(Label totalTouches) {
        touchesModifier();
        this.totalTouches = totalTouches;
    }

    public Button getAddTackles() {
        tacklesModifier();
        return addTackles;
    }

    public void setAddTackles(Button addTackles) {
        tacklesModifier();
        this.addTackles = addTackles;
    }

    public Button getRemoveTackles() {
        tacklesModifier();
        return removeTackles;
    }

    public void setRemoveTackles(Button removeTackles) {
        tacklesModifier();
        this.removeTackles = removeTackles;
    }

    public Label getTotalTackles() {
        tacklesModifier();
        return totalTackles;
    }

    public void setTotalTackles(Label totalTackles) {
        tacklesModifier();
        this.totalTackles = totalTackles;
    }

    Button addGoalsButton;
    Button removeGoalsButton;
    Label totalGoals;
    int goals;
    Button addAssists;
    Button removeAssists;
    Label totalAssists;
    int assists;
    Button addShots;
    Button removeShots;
    Label totalShots;
    int shots;
    Button addCrosses;
    Button removeCrosses;
    Label totalCrosses;
    int crosses;
    Button addDribbles;
    Button removeDribbles;
    Label totalDribbles;
    int dribbles;
    Button addPasses;
    Button removePasses;
    Label totalPasses;
    int passes;
    Button addTouches;
    Button removeTouches;
    Label totalTouches;
    int touches;
    Button addTackles;
    Button removeTackles;
    Label totalTackles;
    int tackles;
    Button update;
    Button reset;
    Label statistics;
    int totalStatistics;


    public void goalsModifier(){
        addGoalsButton.setOnAction(event -> {
            goals++;
            totalGoals.setText("" + goals);
        });
        removeGoalsButton.setOnAction(event -> {
            goals--;
            totalGoals.setText("" + goals);
        });
    }

    public void assistsModifier(){
        addAssists.setOnAction(event -> {
            assists++;
            totalAssists.setText("" + assists);
        });
        removeAssists.setOnAction(event -> {
            assists--;
            totalAssists.setText("" + assists);
        });
    }

    public Button getReset() {
        resetModifier();
        return reset;
    }

    public void setReset(Button reset) {
        resetModifier();
        this.reset = reset;
    }

    public void shotsModifier(){
        addShots.setOnAction(event -> {
            shots++;
            totalShots.setText("" + shots);
        });
        removeShots.setOnAction(event -> {
            shots--;
            totalShots.setText("" + shots);
        });
    }

    public void crossesModifier(){
        addCrosses.setOnAction(event -> {
            crosses++;
            totalCrosses.setText("" + crosses);
        });
        removeCrosses.setOnAction(event -> {
            crosses--;
            totalCrosses.setText("" + crosses);
        });
    }

    public void dribblesModifier(){
        addDribbles.setOnAction(event -> {
            dribbles++;
            totalDribbles.setText("" + dribbles);
        });
        removeDribbles.setOnAction(event -> {
            dribbles--;
            totalDribbles.setText("" + dribbles);
        });
    }

    public void passesModifier(){
        addPasses.setOnAction(event -> {
            passes++;
            totalPasses.setText("" + passes);
        });
        removePasses.setOnAction(event -> {
            passes--;
            totalPasses.setText("" + passes);
        });
    }

    public void touchesModifier(){
        addTouches.setOnAction(event -> {
            touches++;
            totalTouches.setText("" + touches);
        });
        removeTouches.setOnAction(event -> {
            touches--;
            totalTouches.setText("" + touches);
        });
    }

    public void tacklesModifier(){
        addTackles.setOnAction(event -> {
            tackles++;
            totalTackles.setText("" + tackles);
        });
        removeTackles.setOnAction(event -> {
            tackles--;
            totalTackles.setText("" + tackles);
        });
    }

public void statisticsModifier() {
    update.setOnAction(event -> {
        totalStatistics = goals + assists + shots + crosses + dribbles + touches + passes + tackles;
        statistics.setText("" + totalStatistics);
    });
};

    public Label getStatistics() {
        statisticsModifier();
        return statistics;
    }

    public void setStatistics(Label statistics) {
        statisticsModifier();
        this.statistics = statistics;
    }

    public int getTotalStatistics() {
        statisticsModifier();
        return totalStatistics;
    }

    public void setTotalStatistics(int totalStatistics) {
        statisticsModifier();
        this.totalStatistics = totalStatistics;
    }


    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public void resetModifier(){
        reset.setOnAction(event -> {
            goals = 0;
            assists = 0;
            shots = 0;
            crosses = 0;
            dribbles = 0;
            touches = 0;
            tackles = 0;
            passes = 0;

            totalGoals.setText("0");
            totalAssists.setText("0");
            totalShots.setText("0");
            totalCrosses.setText("0");
            totalDribbles.setText("0");
            totalTouches.setText("0");
            totalPasses.setText("0");
            totalTackles.setText("0");

        });

    }

    public PlayerRow() {
        this.firstName = "";
        this.lastName = "";
        this.number = 0;
        this.addGoalsButton = new Button("+");
        this.removeGoalsButton = new Button("-");
        this.totalGoals = new Label("0");
        this.addAssists = new Button("+");
        this.removeAssists = new Button("-");
        this.totalAssists = new Label("0");
        this.addShots = new Button("+");
        this.removeShots = new Button("-");
        this.totalShots = new Label("0");
        this.addCrosses = new Button("+");
        this.removeCrosses = new Button("-");
        this.totalCrosses = new Label("0");
        this.addDribbles = new Button("+");
        this.removeDribbles = new Button("-");
        this.totalDribbles = new Label("0");
        this.addPasses = new Button("+");
        this.removePasses = new Button("-");
        this.totalPasses = new Label("0");
        this.addTouches = new Button("+");
        this.removeTouches = new Button("-");
        this.totalTouches = new Label("0");
        this.addTackles = new Button("+");
        this.removeTackles = new Button("-");
        this.totalTackles = new Label("0");
        this.update = new Button("-->");
        this.reset = new Button("Reset");
        this.statistics = new Label("0");
        this.totalStatistics = 0;

    }


    public PlayerRow(String firstName, String lastName, String number, String assists, String crosses, String dribbles, String goals,
                     String passes, String shots, String tackles, String touches, String total){
        this.firstName = (String) firstName;
        this.lastName = lastName;
        this.number = Integer.parseInt(number);
        this.goals = Integer.parseInt(goals);
        this.addGoalsButton = new Button("+");
        this.removeGoalsButton = new Button("-");
        this.totalGoals = new Label(goals);
        this.assists = Integer.parseInt(assists);
        this.addAssists = new Button("+");
        this.removeAssists = new Button("-");
        this.totalAssists = new Label(assists);
        this.shots = Integer.parseInt(shots);
        this.addShots = new Button("+");
        this.removeShots = new Button("-");
        this.totalShots = new Label(shots);
        this.crosses = Integer.parseInt(crosses);
        this.addCrosses = new Button("+");
        this.removeCrosses = new Button("-");
        this.totalCrosses = new Label(crosses);
        this.dribbles = Integer.parseInt(dribbles);
        this.addDribbles = new Button("+");
        this.removeDribbles = new Button("-");
        this.totalDribbles = new Label(dribbles);
        this.passes = Integer.parseInt(passes);
        this.addPasses = new Button("+");
        this.removePasses = new Button("-");
        this.totalPasses = new Label(passes);
        this.touches = Integer.parseInt(touches);
        this.addTouches = new Button("+");
        this.removeTouches = new Button("-");
        this.totalTouches = new Label(touches);
        this.tackles = Integer.parseInt(tackles);
        this.addTackles = new Button("+");
        this.removeTackles = new Button("-");
        this.totalTackles = new Label(tackles);
        this.update = new Button("-->");
        this.reset = new Button("Reset");
        this.statistics = new Label(total);
        this.totalStatistics = Integer.parseInt(total);


    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public Button getAddGoalsButton(){
        goalsModifier();
        return addGoalsButton;
    }

    public void setAddGoalsButton(Button addGoalsButton) {
        goalsModifier();
        this.addGoalsButton = addGoalsButton;
    }


    public Button getRemoveGoalsButton(){
        goalsModifier();
        return removeGoalsButton;
    }

    public void setRemoveGoalsButton(Button removeGoalsButton){
        goalsModifier();
        this.removeGoalsButton = removeGoalsButton;
    }

    public Label getTotalGoals(){
        goalsModifier();
        return totalGoals;
    }

    public void setTotalGoals(Label totalGoals){
        goalsModifier();
        this.totalGoals = totalGoals;
    }





}

