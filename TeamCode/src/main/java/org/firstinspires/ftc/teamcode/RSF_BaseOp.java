/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Pushbot: Do Not Use Me", group="Pushbot")
public class RSF_BaseOp extends LinearOpMode {
    protected RSF_CollectorModule collector = new RSF_CollectorModule();
    protected RSF_ColorModule color = new RSF_ColorModule();
    protected RSF_DeviceInterfaceModule deviceInterface = new RSF_DeviceInterfaceModule();
    protected RSF_EngineModule engine = new RSF_EngineModule();
    protected RSF_LiftModule lift = new RSF_LiftModule();
    protected RSF_ShooterModule shooter = new RSF_ShooterModule();
    protected RSF_VuforiaModule vuforia = new RSF_VuforiaModule();
    protected ElapsedTime period = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

    }

    protected void Update() {
        telemetry.update();
    }

    protected void Update(long time) throws InterruptedException {
        if (engine.HasEncoders()) {
            telemetry.addData("Encoder LF: ", engine.GetEncoderPosition(RSF_States.EngineMotor.FrontLeft));
            telemetry.addData("Encoder LB: ", engine.GetEncoderPosition(RSF_States.EngineMotor.BackLeft));
            telemetry.addData("Encoder RF: ", engine.GetEncoderPosition(RSF_States.EngineMotor.FrontRight));
            telemetry.addData("Encoder RB: ", engine.GetEncoderPosition(RSF_States.EngineMotor.BackRight));
        }

        telemetry.update();
        WaitForTick(time);
    }

    private void WaitForTick(long periodMs) throws InterruptedException {
        long remaining = periodMs - (long) period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
