/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicVoltageAndFrequencyScalingMethod.implementation;

import SystemEnvironment.Core;
import SystemEnvironment.Processor;
import WorkLoad.CoreSpeed;
import WorkLoad.Job;
import WorkLoad.SharedResource;
import dynamicVoltageAndFrequencyScalingMethod.DynamicVoltageAndFrequencyScalingMethod;
import mcrtsim.Definition;
import mcrtsim.Definition.DVFSType;

/**
 *
 * @author ShiuJia
 */
public class MaxSpeed extends DynamicVoltageAndFrequencyScalingMethod
{
    double maxSpeed;
    public MaxSpeed()
    {
        this.setName("Max Speed");
    }
    
    @Override
    public void definedSpeed(Processor p)
    {
        maxSpeed = p.getCoresSets().get(0).getCoreSpeedSet().getMaxSpeed().getSpeed();
    }

    @Override
    public void jobArrivesProcessorAction(Job j, Processor p)
    {
        
    }

    @Override
    public void jobArrivesCoreAction(Job j, Core c)
    {
        
    }

    @Override
    public void coresExecuteAction()
    {
        
    }

    @Override
    public void coreExecuteAction(Core c)
    {
        c.setCurrentSpeed(this.maxSpeed);
    }

    @Override
    public void jobLockAction(Job j, SharedResource r)
    {
    }

    @Override
    public void jobUnlockAction(Job j, SharedResource r)
    {
        
    }

    @Override
    public void jobCompleteAction(Job j)
    {
        
    }

    @Override
    public void jobDeadlineAction(Job j)
    {
        
    }

    @Override
    public void jobBlockedAction(Job blockedJob, SharedResource blockingRes)
    {
        
    }

    @Override
    public void jobFirstExecuteAction(Job j)
    {
        
    }

    @Override
    public void jobEveryExecuteAction(Job j)
    {
        
    }
}
