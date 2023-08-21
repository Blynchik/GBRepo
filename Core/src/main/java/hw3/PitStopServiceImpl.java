package hw3;

/**
 * Этот класс представляет реализацию интерфейса PitStopService.
 * Он отвечает за выполнение операций проверки двигателей и турбонаддува на пит-стопе.
 */
public class PitStopServiceImpl implements PitStopService {
    private PitStop pitStop;

    /**
     * Конструктор класса PitStopServiceImpl.
     *
     * @param pitStop экземпляр PitStop, который будет использоваться для проверки двигателей и турбонаддува.
     */
    public PitStopServiceImpl(PitStop pitStop) {
        this.pitStop = pitStop;
    }

    /**
     * Метод выполняет проверку всех двигателей на пит-стопе.
     * Для каждого двигателя вызывается метод start(), чтобы запустить двигатель.
     */
    @Override
    public void checkAllEngines() {
        for (int i = 0; i < pitStop.getLength(); i++) {
            pitStop.get(i).start();
        }
    }

    /**
     * Метод выполняет проверку турбонаддува для каждого двигателя на пит-стопе.
     * Если двигатель является экземпляром TurboRegime, вызывается метод turbo(),
     * чтобы активировать режим турбонаддува.
     */
    @Override
    public void checkTurbo() {
        for (int i = 0; i < pitStop.getLength(); i++) {
            if (pitStop.get(i) instanceof TurboRegime) {
                ((TurboRegime) pitStop.get(i)).turbo();
            }
        }
    }
}