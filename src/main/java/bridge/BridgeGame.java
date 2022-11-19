package bridge;

import java.util.List;

public class BridgeGame {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Util util = new Util();

    public boolean move(Map map, List<String> crossable, int index) {
        boolean isWin;
        String moving;
        moving = util.determineWhereToGo();
        map.extendMap(index);
        isWin = map.runMap(moving, crossable.get(index));
        map.endMap();
        return isWin;
    }

    public boolean checkIfWin(List<String> crossable, Map map) {
        map.startMap();
        for (int index=0; index<crossable.size(); index++) {
            boolean isWin = move(map, crossable, index);
            outputView.printMap(map.getMapUpper(), map.getMapLower());
            if (!isWin) {
                return false;
            }
        }
        return true;
    }

    public boolean retry() {
        String continueOrEnd;
        outputView.printContinueOrEndRequest();
        continueOrEnd = inputView.readGameCommand();
        if (continueOrEnd.equals("R")) {
            return true;
        }
        return false;
    }

    public boolean checkIfRetry(boolean isWin) {
        boolean isContinue = true;
        if (!isWin) {
            isContinue = retry();
        }
        if (isWin||!isContinue) {
            isContinue = false;
        }
        return isContinue;
    }

}



