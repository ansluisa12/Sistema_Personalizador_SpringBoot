package org.infatlan.personalizador.service;

import java.util.Map;

import org.infatlan.personalizador.entities.REGION;

public interface REGION_Service {
	public Map<String, Object> getRegion();
    public Map<String, Object> createRegion(REGION region);
}
