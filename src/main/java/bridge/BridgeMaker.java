package bridge;

import java.util.List;
import java.util.ArrayList;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private int limitSize;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public void addNumber(List<String> crossable, int addNumber) {
        if (addNumber == 0) {
            crossable.add("D");
        } else if (addNumber == 1) {
            crossable.add("U");
        }
    }

    public List<String> makeBridge(int size) {
        this.limitSize = size;
        List<String> crossable = new ArrayList<>();
        int addNumber;
        for (int index = 0; index < size; index++) {
            addNumber = bridgeNumberGenerator.generate();
            addNumber(crossable,addNumber);
        }
        return crossable;
    }
}


