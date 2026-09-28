CREATE TABLE elder
(
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR(255) NOT NULL,
    date_of_birth       DATE,
    address             VARCHAR(500),
    baseline_wake_time  TIME,
    baseline_sleep_time TIME
);

CREATE TABLE caregiver
(
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR(255) NOT NULL,
    relation_to_elder   VARCHAR(100),
    phone               VARCHAR(20),
    email               VARCHAR(255),
    escalation_priority INT          NOT NULL
);

CREATE TABLE elder_caregiver_link
(
    elder_id     BIGINT NOT NULL REFERENCES elder (id) ON DELETE CASCADE,
    caregiver_id BIGINT NOT NULL REFERENCES caregiver (id) ON DELETE CASCADE,
    PRIMARY KEY (elder_id, caregiver_id)
);

CREATE TABLE medication_schedule
(
    id              BIGSERIAL PRIMARY KEY,
    elder_id        BIGINT       NOT NULL REFERENCES elder (id) ON DELETE CASCADE,
    medication_name VARCHAR(255) NOT NULL,
    scheduled_time  TIME         NOT NULL,
    dosage          VARCHAR(100)
);

CREATE TABLE daily_log
(
    id                   BIGSERIAL PRIMARY KEY,
    elder_id             BIGINT NOT NULL REFERENCES elder (id) ON DELETE CASCADE,
    log_date             DATE   NOT NULL,
    wake_time            TIME,
    sleep_time           TIME,
    activity_count       INT DEFAULT 0,
    outgoing_calls_count INT DEFAULT 0
);

CREATE TABLE medication_log
(
    id                     BIGSERIAL PRIMARY KEY,
    daily_log_id           BIGINT  NOT NULL REFERENCES daily_log (id) ON DELETE CASCADE,
    medication_schedule_id BIGINT  NOT NULL REFERENCES medication_schedule (id),
    was_taken              BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE alert_history
(
    id           BIGSERIAL PRIMARY KEY,
    elder_id     BIGINT      NOT NULL REFERENCES elder (id) ON DELETE CASCADE,
    triggered_at TIMESTAMP   NOT NULL DEFAULT now(),
    severity     VARCHAR(20) NOT NULL,
    source       VARCHAR(20) NOT NULL,
    explanation  TEXT,
    resolved     BOOLEAN     NOT NULL DEFAULT FALSE,
    resolved_at  TIMESTAMP
);
CREATE TABLE elder_caregiver_link
(
    elder_id     BIGINT NOT NULL REFERENCES elder (id) ON DELETE CASCADE,
    caregiver_id BIGINT NOT NULL REFERENCES caregiver (id) ON DELETE CASCADE,
    PRIMARY KEY (elder_id, caregiver_id)
);