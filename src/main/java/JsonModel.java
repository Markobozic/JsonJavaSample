import java.util.List;

public class JsonModel {

    private Boolean madeWithPython;
    private List<Integer> backwardsInPython;
    private String description;

    public JsonModel() {}

    private JsonModel(Builder builder) {
        setMadeWithPython(builder.madeWithPython);
        setBackwardsInPython(builder.backwardsInPython);
        setDescription(builder.description);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getMadeWithPython() {
        return madeWithPython;
    }

    public void setMadeWithPython(Boolean madeWithPython) {
        this.madeWithPython = madeWithPython;
    }

    public List<Integer> getBackwardsInPython() {
        return backwardsInPython;
    }

    public void setBackwardsInPython(List<Integer> backwardsInPython) {
        this.backwardsInPython = backwardsInPython;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static final class Builder {
        private Boolean madeWithPython;
        private List<Integer> backwardsInPython;
        private String description;

        private Builder() {
        }

        public Builder setMadeWithPython(Boolean madeWithPython) {
            this.madeWithPython = madeWithPython;
            return this;
        }

        public Builder setBackwardsInPython(List<Integer> backwardsInPython) {
            this.backwardsInPython = backwardsInPython;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public JsonModel build() {
            return new JsonModel(this);
        }
    }
}
